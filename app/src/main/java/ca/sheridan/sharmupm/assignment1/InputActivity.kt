    package ca.sheridan.sharmupm.assignment1

    import android.content.Intent
    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import ca.sheridan.sharmupm.assignment1.databinding.ActivityInputBinding
    import java.util.*

    class InputActivity : AppCompatActivity() {
        private lateinit var binding: ActivityInputBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityInputBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.sendButton.setOnClickListener{showOutput()}
        }

        private fun showOutput(){
            // get the selected game choice text
            val player = when (binding.messageGroup.checkedRadioButtonId) {
                R.id.rock_button -> getString(R.string.rad_rock)
                R.id.paper_button -> getString(R.string.rad_paper)
                R.id.scissors_button -> getString(R.string.rad_scissors)
                else -> getString(R.string.undefined)
            }
            val computer = computerPlay()
            val play = checkPlayerIsWinner(player, computer)
            val tie = checkTie(player,computer)
            val winner = getWinner(tie, play)

            val intent = Intent(this, OutputActivity::class.java).apply {
                putExtra(OutputActivity.MESSAGE_TEXT_KEY, player)
                putExtra(OutputActivity.COMPUTER_PLAY, computer)
                putExtra(OutputActivity.WINNER,winner)
            }
            startActivity(intent)
        }
        private fun computerPlay(): String {
            val list = arrayOf("Rock", "Paper", "Scissors")
            val r = Random()
            return list[r.nextInt(list.size)]
        }

        private fun checkTie(player: String, computer: String): Boolean{
            return player == computer
        }

        private fun checkPlayerIsWinner(player: String, computer: String): Boolean {
                return (player == "Rock" && computer == "Scissors") ||
                        (player == "Paper" && computer == "Rock") ||
                        (player == "Scissors" && computer == "Paper")
        }

        private  fun getWinner(tie: Boolean, playerOneWin: Boolean): String{
            if(tie){
                println("TIE")
                return "TIE"
            }else if(playerOneWin){
                println("You win")
                return "You Win"
            }else{
                println("Computer Wins")
                return "Computer Wins"
            }
        }

    }