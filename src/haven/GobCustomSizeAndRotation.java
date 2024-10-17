package haven;

import haven.render.Location;
import haven.render.Pipe;

public class GobCustomSizeAndRotation implements Gob.SetupMod {
    Gob gob;
    
    private Pipe.Op op = null;
    
    public void update(Gob gob) {
    this.gob = gob;
	if(gob.getres() == null || gob.getres().name == null) {
	    op = null;
	    return;
	}
    update();
    }
    
    private void update() {

	    op = makeScale();

    }
    
    private Pipe.Op makeScale() {
    if (gob.getres() != null) {
        String resName = gob.getres().name;
        if(OptWnd.flatCupboardsCheckBox.a && resName.equals("gfx/terobjs/cupboard"))
            return Pipe.Op.compose(Location.rot(new Coord3f(0, 1, 0), 4.71f), Location.scale(0.2f, 1, 0.55f), Location.xlate(new Coord3f(6,0,-9)));
        else
            return null;
    } else
        return null;
    }
    
    @Override
    public Pipe.Op gobstate() {
	return op;
    }
}
