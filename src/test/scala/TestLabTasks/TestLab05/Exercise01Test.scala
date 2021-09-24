package Lab05

import org.scalatest._
import chiseltest._
import chisel3._
  
class Exercise01Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 01 Test" in {
        
        test(new ALU_case) { obj =>
        
        obj.io.inputA.poke(2.S)
        obj.io.inputB.poke(3.S)
        obj.io.sel.poke("b1001".U)

        obj.clock.step(1)

        obj.io.output.expect(1.S)
             
        }
    }
} 