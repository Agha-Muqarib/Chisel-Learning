package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Example01Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 01 Test" in {
    
    test(new Decoder_2to4) { c =>
    
    c.io.in.poke("b01".U)
  
    c.clock.step(10)

    c.io.out.expect("b0010".U)

    }
}
}