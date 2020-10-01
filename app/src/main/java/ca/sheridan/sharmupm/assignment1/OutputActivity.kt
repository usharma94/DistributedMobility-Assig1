package ca.sheridan.sharmupm.assignment1
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.sheridan.sharmupm.assignment1.databinding.ActivityOutputBinding
import kotlinx.android.synthetic.main.activity_output.*

class OutputActivity   : AppCompatActivity(){
    companion object{
        const val MESSAGE_TEXT_KEY = "choice"
        const val COMPUTER_PLAY = "computerPlay"
        const val WINNER = "winner"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.messageText.text = getString(R.string.You) + intent.getStringExtra(MESSAGE_TEXT_KEY)
        binding.computerPlayText.text = getString(R.string.Computer) + intent.getStringExtra(COMPUTER_PLAY)

//        Logic to display image based on who wins the game
        if(intent.getStringExtra(WINNER) == "You Win"){
            game_img.setImageResource(R.drawable.ic_baseline_mood_24)
        }else if(intent.getStringExtra(WINNER) =="Computer Wins"){
            game_img.setImageResource(R.drawable.ic_baseline_mood_bad_24)
        }else{
            game_img.setImageResource(R.drawable.ic_baseline_block_24)
        }

        binding.winnerOutput.text = intent.getStringExtra(WINNER)

        // make the close button work
        binding.closeButton.setOnClickListener { finish() }
    }
}