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

sealed trait AlgoList[+A]
case object Nil extends AlgoList[Nothing]
case class Cons[+A](head: A, tail: AlgoList[A]) extends AlgoList[A]

object AlgoList{

  def append[A](a1: AlgoList[A], a2: AlgoList[A]): AlgoList[A] =  a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2))
  } 

  implicit val al: Monad[AlgoList] = new Monad[AlgoList]{

    override def flatMap[A, B](fa: AlgoList[A])(f: A => AlgoList[B]): AlgoList[B] = ???

    override def tailRecM[A, B](a: A)(f: A => AlgoList[Either[A,B]]): AlgoList[B] = flatMap(f(a)) {
      case Right(b) => pure(b)
      case Left(nextA) => tailRecM(nextA)(f)
    }

    override def pure[A](x: A): AlgoList[A] = ???
  }

  implicit def eqMop[A: Eq]: Eq[AlgoList[A]] = Eq.fromUniversalEquals
}