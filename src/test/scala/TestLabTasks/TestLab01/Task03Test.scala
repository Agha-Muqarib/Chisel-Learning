package Lab01

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Task03Test extends FreeSpec with ChiselScalatestTester {
"Task 03 Test" in {
    
    test(new Task03(8, 255)).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>

    c.clock.step(20)

    }
}
}