package Lab06

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Example06Test extends FreeSpec with ChiselScalatestTester {
    
    "Exammple 06 Test" in {
    
    test(new My_Queue).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
    
    c.io.in.valid.poke(true.B)
    c.io.in.ready.poke(true.B)
    c.io.in.bits.poke(5.U)

    c.clock.step(20)

    }
}
}