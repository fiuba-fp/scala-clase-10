import scala.util.Try
import cats._



Monad[List].pure("a")

Monad[List].flatMap(List("hola","mundo","!"))( (s: String) => s.toList )

