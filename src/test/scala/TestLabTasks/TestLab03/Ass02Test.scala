package Lab03

import org.scalatest._
import chiseltest._
import chisel3._

class Ass02Test extends FreeSpec with ChiselScalatestTester {
    
    "Ass 02 Test" in {
    
        test(new ImmdValGen) { c =>

        c.io.instr.poke(1.U)
        c.io.pc.poke(1.U)

        c.clock.step(10)

        c.io.immSel.expect(0.U)

    }
}
}