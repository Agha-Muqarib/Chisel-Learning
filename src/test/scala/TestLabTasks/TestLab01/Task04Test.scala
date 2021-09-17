package Lab01

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Task04Test extends FreeSpec with ChiselScalatestTester {
"Task 04 Test" in {
    
    test(new Task04(8)).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>


    c.io.data_in.poke(0.U)
    c.io.reload.poke(true.B)
    c.clock.step(20)
   

    }
}
}