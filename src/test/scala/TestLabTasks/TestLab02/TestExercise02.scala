package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise02Test extends FreeSpec with ChiselScalatestTester {
"Exercise 02 Test" in {
    
    test(new Exercise02) { c =>

    c.io.x.poke(4.U)
    c.io.y.poke(2.U)
    c.io.high_Byte.poke("b10101".U) 
    c.io.low_Byte.poke("b01".U)

    c.clock.step(10)
    c.io.con_cat.expect("b1010101".U)
    c.io.dup.expect("b10101010".U)
    // c.io.Data.expect(2.U)
    c.io.All_Ones.expect("b0".U)
    c.io.Any_One.expect("b1".U)
    c.io.Parity_Check.expect(false.B)

    }
}
}