// Branch control ( Assignment )

package Lab03

import chisel3._
import chisel3.util._

class LM_IO_Interface_BranchControl extends Bundle {
    
    val fnct3= Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(UInt(32.W))
    val arg_y = Input(UInt(32.W))
    val br_taken = Output(Bool())
}

class BranchControl extends Module {
    
    val io = IO (new LM_IO_Interface_BranchControl)
    

}