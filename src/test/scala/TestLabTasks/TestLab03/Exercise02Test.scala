package Lab03

import org.scalatest._
import chiseltest._
import chisel3._
  
class Exercise02Test extends FreeSpec with ChiselScalatestTester {

    "Exercise 02 Test" in {
        
        test(new SwitchALU) { obj =>
        
        obj.io.inputA.poke(2.S)
        obj.io.inputB.poke(3.S)
        obj.io.sel.poke("b1001".U)

        obj.clock.step(1)

        obj.io.output.expect(1.S)
             
        }
    }

} 