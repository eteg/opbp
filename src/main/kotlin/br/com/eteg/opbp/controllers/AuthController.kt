package br.com.eteg.opbp.controllers

import br.com.eteg.opbp.entities.auth.Account
import br.com.eteg.opbp.entities.auth.Authority
import br.com.eteg.opbp.repositories.AccountRepository
import br.com.eteg.opbp.repositories.AuthorityRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContext
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpSession

@Controller
class AuthController(
        val authenticationManager: AuthenticationManager,
        val accountRepository: AccountRepository,
        val authorityRepository: AuthorityRepository) {
    @GetMapping("/loggedUser")
    @ResponseBody
    fun getLoggedUser(): String {
        try {
            val principal = SecurityContextHolder.getContext().authentication.principal
            return if (principal is User) principal.username else ""
        } catch (e: Exception) {
            return ""
        }
    }

    @PostMapping("/signIn")
    fun login(@RequestParam("username") username: String,
              @RequestParam("password") password: String,
              request: HttpServletRequest): ResponseEntity<Any> {
        try {
            val authentication: Authentication =
                    authenticationManager.authenticate(UsernamePasswordAuthenticationToken(username, password))

            val securityContext: SecurityContext = SecurityContextHolder.getContext()
            securityContext.authentication = authentication

            val session: HttpSession = request.getSession(true)
            session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext)

            return ResponseEntity<Any>(HttpStatus.OK)
        } catch (e: AuthenticationException) {
            return ResponseEntity <Any>(HttpStatus.FORBIDDEN)
        }
    }

    @PostMapping("/signUp")
    fun signUp(@RequestParam("username") username: String,
               @RequestParam("password") password: String,
               @RequestParam("name") name: String,
               @RequestParam("email") email: String,
               request: HttpServletRequest): ResponseEntity<Any> {
        val basicAuthority: Authority = authorityRepository.findByName("BASIC")!!
        val account = Account(username = username, password = password, name = name,
                email = email, authorities = arrayListOf(basicAuthority))
        accountRepository.save(account)
        return ResponseEntity <Any>(HttpStatus.OK)
    }

    @PostMapping("/signOut")
    fun logout(session: HttpSession): ResponseEntity<Any> {
        session.invalidate()
        return ResponseEntity<Any>(HttpStatus.OK)
    }
}
