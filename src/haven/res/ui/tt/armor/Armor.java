package haven.res.ui.tt.armor;/* Preprocessed source code */
import haven.*;
import java.awt.image.BufferedImage;

/* >tt: haven.res.ui.tt.armor.Armor */
@haven.FromResource(name = "ui/tt/armor", version = 4)
public class Armor extends ItemInfo.Tip {
    public final int hard, soft;

    public Armor(Owner owner, int hard, int soft) {
	super(owner);
	this.hard = hard;
	this.soft = soft;
    }

    public static ItemInfo mkinfo(Owner owner, Object... args) {
	return(new Armor(owner, (Integer)args[1], (Integer)args[2]));
    }

    public BufferedImage tipimg() {
	return(RichText.render(String.format("$col[85,164,237]{Armor}: %,d (%,d + %,d)", hard+soft, hard, soft), 0).img);
    }

    public static class Fac implements ItemInfo.InfoFactory {
        public Fac() {}
        public ItemInfo build(Owner owner, Raw raw, Object... args) {
            return mkinfo(owner, args);
        }
    }
}
