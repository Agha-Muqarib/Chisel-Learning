package Example

import org.scalatest._
import chiseltest._
import chisel3._
  
class ALUTest extends FreeSpec with ChiselScalatestTester {

    "ALU Test" in {
        
        test(new ALU) { obj =>
        
        obj.io.inputA.poke(2.S)
        obj.io.inputB.poke(3.S)
        obj.io.sel.poke("b1001".U)

        obj.clock.step(1)

        obj.io.output.expect(1.S)
             
        }
    }

} 