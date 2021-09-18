package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Example03Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 03 Test" in {
        
        test(new Decoder_Switch) { c =>
    
        c.io.in.poke("b00".U)
  
        c.clock.step(10)

        c.io.out.expect("b0001".U)
    
        }
    }
}