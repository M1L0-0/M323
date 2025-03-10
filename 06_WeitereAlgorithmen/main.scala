import cats.effect.{IO, IOApp, Sync}
import cats.effect.kernel.Ref
import cats.syntax.all.*
import cats.effect.unsafe.implicits.global

import java.util.concurrent.TimeUnit
import scala.concurrent.duration.FiniteDuration
import scala.util.Random

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@main
def main(): Unit =
  // LazyList
  // Aufgaben in Theorie
  val lazyList1: LazyList[Int] = {
    def loop(v: Int): LazyList[Int] = v #:: loop(v + 1)
    loop(1)
  }
  println(lazyList1.take(5).toList)

  // Legerverwaltung
  val test = for {
    product <- Ref.of[IO, Int](3)
    singleUpdate = (v:Int) => {
      IO.sleep(FiniteDuration((math.random()*10).toInt, TimeUnit.SECONDS)).map(_ => {
        println("operation finished: " + v)
        product.getAndUpdate(i=> i + v)
      })
    }
    _ <- List(singleUpdate(3), singleUpdate(-2)).parSequence
    p <- product.get
  } yield p
  println(test.unsafeRunSync())

def updateProduct(product: Int, v: Int): IO[Int] = {
  IO.delay(updateProductImpure(product, v))
}

def updateProductImpure(product: Int, v: Int): Int = {
  product + v
}




