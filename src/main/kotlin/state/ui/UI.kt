package state.ui

import java.awt.FlowLayout
import java.awt.event.ActionEvent
import javax.swing.*


class UI(private val player: Player) {
    fun init() {
        val frame = JFrame("Test player")
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        val context = JPanel()
        context.layout = BoxLayout(context, BoxLayout.Y_AXIS)
        frame.contentPane.add(context)
        val buttons = JPanel(FlowLayout(FlowLayout.CENTER))
        context.add(textField)
        context.add(buttons)

// Делегаты контекста, обрабатывающие ввод пользователя в объект состояния. Естественно,
        // результат будет зависеть от того, какое состояние активно в данный момент, поскольку все
        // состояния могут обрабатывать ввод по-разному.
        val play = JButton("Play")
        play.addActionListener { e: ActionEvent? ->
            textField.text = player.state.onPlay()
        }
        val stop = JButton("Stop")
        stop.addActionListener { e: ActionEvent? ->
            textField.text = player.state.onLock()
        }
        val next = JButton("Next")
        next.addActionListener { e: ActionEvent? ->
            textField.text = player.state.onNext()
        }
        val prev = JButton("Prev")
        prev.addActionListener { e: ActionEvent? ->
            textField.text = player.state.onPrevious()
        }
        frame.isVisible = true
        frame.setSize(300, 100)
        buttons.add(play)
        buttons.add(stop)
        buttons.add(next)
        buttons.add(prev)
    }

    companion object {
        private val textField = JTextField()
    }
}