package htw.berlin.ui;

import org.springframework.shell.jline.PromptProvider;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;



@Component
public class BurgerBotPromptProvider implements PromptProvider {

    private boolean understood = true;

    @Override
    public AttributedString getPrompt() {
        if (this.understood) {
            return new AttributedString("BURGER-BOT:>",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.GREEN));
        }
        else {
            return new AttributedString("BURGER-BOT:>",
                    AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
        }
    }

    @EventListener
    public void handle(InputEvent event) {
        this.understood = event.getUnderstood();
    }
}