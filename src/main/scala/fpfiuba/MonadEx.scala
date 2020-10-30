package fpfiuba

import cats._

sealed trait MonadOption[+A]
case object None extends MonadOption[Nothing]
case class Some[+A](a: A) extends MonadOption[A]


object MonadOption {
  
    implicit val em: Monad[MonadOption] = new Monad[MonadOption]{

      override def flatMap[A, B](fa: MonadOption[A])(f: A => MonadOption[B]): MonadOption[B] = ???

      override def tailRecM[A, B](a: A)(f: A => MonadOption[Either[A,B]]): MonadOption[B] = f(a) match {
        case None => None
        case Some(Left(nextA)) => tailRecM(nextA)(f)
        case Some(Right(b)) => Some(b)
      }

      override def pure[A](x: A): MonadOption[A] = ???
    }

    implicit def eqMop[A: Eq]: Eq[MonadOption[A]] = Eq.fromUniversalEquals
}
