package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Example02Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 02 Test" in {
    
    test(new Encoder4to2) { c =>
    
    c.io.in.poke("b0001".U)
  
    c.clock.step(10)

    c.io.out.expect("b00".U)

    }
}
}