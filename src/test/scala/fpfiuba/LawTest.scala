package fpfiuba

import org.scalatest.funsuite.AnyFunSuite
import cats.implicits._
import cats.laws.discipline.MonadTests
import cats.laws.discipline.FunctorTests
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.scalacheck.Checkers
import org.typelevel.discipline.scalatest.FunSuiteDiscipline
import org.scalacheck.ScalacheckShapeless._
//import arbitraries._

class LawTest extends AnyFunSuite with FunSuiteDiscipline with Checkers {
  checkAll("MonadOption.MonadLaws", MonadTests[MonadOption].monad[Int,Int,String] )
}
