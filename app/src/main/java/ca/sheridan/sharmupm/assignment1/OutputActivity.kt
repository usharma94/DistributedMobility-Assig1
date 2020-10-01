package ca.sheridan.sharmupm.assignment1
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import ca.sheridan.sharmupm.assignment1.databinding.ActivityOutputBinding

class OutputActivity   : AppCompatActivity(){
    companion object{
        const val MESSAGE_TEXT_KEY = "message"
        const val IS_URGENT_KEY = "urgent"
        const val COMPUTER_PLAY = "computerPlay"
        const val WINNER = "winner"
    }

    private lateinit var binding: ActivityOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // get and display the message data
//        val urgent = intent.getBooleanExtra(IS_URGENT_KEY, true)
//        binding.isUrgentOutput.text =
//            getString(if (urgent) R.string.urgent else R.string.not_urgent)
        binding.messageText.text = getString(R.string.You) + intent.getStringExtra(MESSAGE_TEXT_KEY)
        binding.computerPlayText.text = getString(R.string.Computer) + intent.getStringExtra(COMPUTER_PLAY)
        binding.isUrgentOutput.text = intent.getStringExtra(WINNER)


        // make the close button work
        binding.closeButton.setOnClickListener { finish() }
    }
}