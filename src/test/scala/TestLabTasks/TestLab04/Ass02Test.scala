package Lab04

import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random


class Ass02Test extends FreeSpec with ChiselScalatestTester {
    
    "Ass 02 Test" in {
        
        test(new ImmdValGen) { c =>
        
        val opcodeArray = Array("h00400613","h00300513","h00c516b3")

        for (i <- 0 until 100) {
            
            val instructions = opcodeArray(Random.nextInt(2))
            val result = instructions match {

                case ("h00300513") => 3
                case ("h00400613") => 4
                case ("h00c516b3") => 48
        }

        c.io.instr.poke(instructions.U)
        c.io.pc.poke(4.U)

        c.io.immSel.expect(result.U)

      }
    }
  }
}