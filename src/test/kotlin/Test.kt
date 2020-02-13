import com.mongodb.internal.connection.tlschannel.util.Util.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

@RunWith(JUnit4::class)
class Test {
    @Test
    fun testPassword() {
        var encoder: Pbkdf2PasswordEncoder = Pbkdf2PasswordEncoder()
        val result = encoder.encode("myPassword")
        assertTrue(encoder.matches("myPassword", result))
    }
}