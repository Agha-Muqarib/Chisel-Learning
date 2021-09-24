package Lab06

import org.scalatest._
import chiseltest._
import chisel3._

class Example03Test extends FreeSpec with ChiselScalatestTester {
    
    "Example 03 Test" in {
    
        test(new Example03) { c =>

        // c.io.inputA.poke(2.S)
        // c.io.inputB.poke(2.S)

        // c.io.funct3.poke("b000".U)

        c.clock.step(10)

        // c.io.branchTaken.expect(1.B)

    }
}
}