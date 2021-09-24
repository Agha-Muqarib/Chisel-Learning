package Lab06

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Example05Test extends FreeSpec with ChiselScalatestTester {
    
    "Exammple 05 Test" in {
    
    test(new Pipe).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
    
    c.io.in.valid.poke(1.B)
    c.io.in.bits.poke(5.U)
    c.clock.step(20)

    }
}
}