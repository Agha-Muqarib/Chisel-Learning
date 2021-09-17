package Lab02

import org.scalatest._
import chiseltest._
import chisel3._

class TestTask03 extends FreeSpec with ChiselScalatestTester {

    "Test Task 03" in {

        test(new Task03) {c =>

        c.io.in0.poke(0.U)
        c.io.in1.poke(0.U)
        c.io.in2.poke(0.U)
        c.io.in3.poke(1.U)

        c.clock.step(1)

        c.io.out.expect("b11".U)

        }
    }
}