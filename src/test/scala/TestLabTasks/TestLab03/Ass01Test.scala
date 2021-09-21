package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

class Ass01Test extends FreeSpec with ChiselScalatestTester {
    
    "Ass 01 Test" in {
    
        test(new BranchControl) { c =>

        c.io.inputA.poke(2.S)
        c.io.inputB.poke(2.S)

        c.io.funct3.poke("b000".U)

        c.clock.step(10)

        c.io.branchTaken.expect(1.B)

    }
}
}