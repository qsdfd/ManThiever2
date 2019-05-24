import org.osbot.rs07.api.map.Area;
import org.osbot.rs07.api.map.Position;
import org.osbot.rs07.api.model.NPC;
import org.osbot.rs07.api.ui.Message;
import org.osbot.rs07.api.ui.Skill;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

import java.util.concurrent.TimeUnit;
import java.awt.*;

@ScriptManifest(name = "Man Thiever", author = "dokato", version = 2.5, info = "", logo = "") 
public class MainManThiever extends Script {
	
	private static final Color standardTxtColor = new Color(255, 255, 255);
	
	private boolean startb = true;
	
    private long timeRan;
    private long timeBegan;
	private long timeBotted;
	
	private String status;
	@Override
    public void onStart(){
		this.timeBegan = System.currentTimeMillis();
		this.timeBotted = 0;
    }
    
    @Override
    public void onExit() {
    }


    @Override
    public int onLoop() throws InterruptedException{
    	status="loop started";
    	procedures();
    	if(!hasGoodThievingLvl()){
			if(inThievPlace()){
				thiev();
			}else{
				goToThievPlace();
			}
    	}else{
    		goToDruidz();
    	}
    	
    	status="loop ended";
    	return 0;
    }

	private void goToDruidz() throws InterruptedException {
		if(inDruidzArea())
			stop();
		else{
			if(toArdyRoad()){
				goToDruidzArea();
			}else if(!myPlayer().isAnimating()){
				status="need to tele to cammy";
				if(getInventory().contains("Camelot teleport")){
					if(getBank().isOpen()){
	    				getBank().close();
	    				sleep(random(200,500));
					}
					status="about to tele to cammy";
					if(!myPlayer().isAnimating()){
						status="teleing to cammy with tab";
						getInventory().getItem("Camelot teleport").interact("Break");
						sleep(random(900,1400));
					}
				}else{
					status="gonna get the cammy tab from bank";
					if(inBank()){
		    			bank();
		    		}else{
		    			goToBank();
		    		}
				}
			}
		}
		
	}

	private boolean hasGoodThievingLvl() {
		return getSkills().getStatic(Skill.THIEVING) >= 46;
	}

    @Override
    public void onPaint(Graphics2D g1){
    	
    	if(this.startb){
    		this.startb=false;
    		this.timeBegan=System.currentTimeMillis();
    	}
    	this.timeRan = (System.currentTimeMillis() - this.timeBegan);
		
		Graphics2D g = g1;

		int startY = 120;
		int increment = 15;
		int value = (-increment);
		int x = 20;
		
		g.setFont(new Font("Arial", 0, 13));
		g.setColor(standardTxtColor);
		g.drawString("Acc: " + getBot().getUsername().substring(0, getBot().getUsername().indexOf('@')), x,getY(startY, value+=increment));
		g.drawString("World: " + getWorlds().getCurrentWorld(),x,getY(startY, value+=increment));
		value+=increment;
		g.drawString("Version: " + getVersion(), x, getY(startY, value+=increment));
		g.drawString("Runtime: " + ft(this.timeRan), x, getY(startY, value+=increment));
		g.drawString("Time botted: " + ft(this.timeBotted), x, getY(startY, value+=increment));
		g.drawString("Status: " + status, x, getY(startY, value+=increment));
		value+=increment;
		g.drawString("thiev lvl: " + getSkills().getStatic(Skill.THIEVING), x, getY(startY, value+=increment));
		g.drawString(""+getSkills().experienceToLevel(Skill.THIEVING), x, getY(startY, value+=increment));
		
		
    }
    
    private int getY(int startY, int value){
		return startY + value;
	}
    
    private void fillRect(Graphics2D g, Rectangle rect){
		g.fillRect(rect.x, rect.y, rect.width, rect.height);
	}
    
    public void onMessage(Message message) throws InterruptedException {
    }
    
    private void goToDruidzArea(){
    	status="Walking to druidz Area";
    	if(getMap().canReach(new Position(2617,3337,0)))
			getWalking().walk(new Area(2617,3337,2619,3337));
    	else if(getMap().canReach(new Position(2623,3337,0)))
			getWalking().walk(new Area(2623,3338,2627,3335));
    	else if(getMap().canReach(new Position(2629,3335,0)))
			getWalking().walk(new Area(2629,3335,2631,3337));
    	else if(getMap().canReach(new Position(2636,3338,0)))
			getWalking().walk(new Area(2636,3338,2634,3343));
    	else if(getMap().canReach(new Position(2636,3347,0)))
			getWalking().walk(new Area(2636,3347,2635,3350));
    	else if(getMap().canReach(new Position(2637,3356,0)))
			getWalking().walk(new Area(2637,3356,2636,3361));
    	else if(getMap().canReach(new Position(2637,3365,0)))
			getWalking().walk(new Area(2637,3365,2636,3369));
    	else if(getMap().canReach(new Position(2636,3372,0)))
			getWalking().walk(new Area(2636,3372,2640,3374));
    	else if(getMap().canReach(new Position(2646,3377,0)))
			getWalking().walk(new Area(2646,3377,2647,3382));
    	else if(getMap().canReach(new Position(2650,3385,0)))
			getWalking().walk(new Area(2650,3385,2655,3388));
    	else if(getMap().canReach(new Position(2656,3392,0)))
			getWalking().walk(new Area(2656,3392,2661,3394));
    	else if(getMap().canReach(new Position(2665,3396,0)))
			getWalking().walk(new Area(2665,3396,2670,3398));
    	else if(getMap().canReach(new Position(2673,3399,0)))
			getWalking().walk(new Area(2673,3399,2677,3401));
    	else if(getMap().canReach(new Position(2680,3404,0)))
			getWalking().walk(new Area(2680,3404,2685,3411));
    	else if(getMap().canReach(new Position(2687,3411,0)))
			getWalking().walk(new Area(2687,3411,2689,3417));
    	else if(getMap().canReach(new Position(2690,3418,0)))
			getWalking().walk(new Area(2690,3418,2692,3423));
    	else if(getMap().canReach(new Position(2694,3423,0)))
			getWalking().walk(new Area(2694,3423,2698,3428));
    	else if(getMap().canReach(new Position(2701,3427,0)))
			getWalking().walk(new Area(2701,3427,2705,3432));
    	else if(getMap().canReach(new Position(2706,3432,0)))
			getWalking().walk(new Area(2706,3432,2708,3437));
    	else if(getMap().canReach(new Position(2708,3438,0)))
			getWalking().walk(new Area(2708,3438,2711,3442));
    	else if(getMap().canReach(new Position(2710,3443,0)))
			getWalking().walk(new Area(2710,3443,2708,3446));
    	else if(getMap().canReach(new Position(2713,3448,0)))
			getWalking().walk(new Area(2713,3448,2712,3453));
    	else if(getMap().canReach(new Position(2715,3453,0)))
			getWalking().walk(new Area(2715,3453,2720,3455));
    	else if(getMap().canReach(new Position(2720,3456,0)))
			getWalking().walk(new Area(2720,3456,2723,3461));
    	else if(getMap().canReach(new Position(2724,3461,0)))
			getWalking().walk(new Area(2724,3461,2728,3464));
    	else if(getMap().canReach(new Position(2723,3466,0)))
			getWalking().walk(new Area(2723,3466,2721,3470));
    	else if(getMap().canReach(new Position(2723,3471,0)))
			getWalking().walk(new Area(2723,3471,2726,3476));
    	else if(getMap().canReach(new Position(2727,3476,0)))
			getWalking().walk(new Area(2727,3476,2731,3479));
    	else if(getMap().canReach(new Position(2731,3477,0)))
			getWalking().walk(new Area(2731,3477,2737,3478));
    	else if(getMap().canReach(new Position(2739,3480,0)))
			getWalking().walk(new Area(2739,3480,2744,3477));
    	else if(getMap().canReach(new Position(2746,3479,0)))
			getWalking().walk(new Area(2746,3479,2749,3475));
    	else if(getMap().canReach(new Position(2751,3478,0)))
			getWalking().walk(new Area(2751,3478,2754,3477));
    }
    
    private boolean toArdyRoad(){
    	status="Returning toArdyRoad";
    	return myPosition().getX() < 2770;
    }
    
    private boolean inDruidzArea(){
    	status="Returning in druidz area";
    	return myPosition().getX() < 2626;
    }
    
    private void bank() throws InterruptedException{
    	status="about to bank";
    	if(getBank().isOpen()){
			status="gonna withdraw the cammy tab from bank";
			if(getBank().contains("Camelot teleport")){
				status="withdrawing cammy tab from bank";
				getBank().withdraw("Camelot teleport", 1);
				sleep(random(200,600));
			}
    	}else if(!myPlayer().isMoving()){
    		status="interacting with booth";
    		objects.closest(18491/*bank booth*/).interact("Bank");
    		sleep(random(1200,2123));
    	}
    }
    
    private void goToBank() throws InterruptedException{
    	status="going to bank";
    	
    	if(!myPlayer().isMoving()){
    		if(getMap().canReach(objects.closest("Staircase"))){
	    		status="walking to staircase";
	    		getWalking().walk(objects.closest("Staircase"));
				status="climbing up ";
	    		objects.closest("Staircase").interact("Climb-up");
	    		sleep(random(200,400));
    		}else{
//    			
    		}
		}
    }
    
    private boolean inBank(){
    	status="returning inBank";
    	return myPosition().getZ()==2;
    }
    
    private void thiev() throws InterruptedException{
    	status="about to thiev";
    	NPC toThiev = getNpcs().closest(3083,3084,3080);
		if(!myPlayer().isMoving() && !myPlayer().isAnimating() && !myPlayer().isUnderAttack() && !toThiev.isAnimating()){
			toThiev.interact("Pickpocket");
			sleep(random(1500,2100));
		}
    			
    }
    
    private void goToThievPlace() throws InterruptedException{
    	status="entered goTothievPlace";
    	if(getMap().canReach(new Position(3235,3207,0)))
    		getWalking().walk(new Area(3236,3207,3234,3209));
    }
    
    private boolean inThievPlace(){
    	status="returning inThievPlace";
    	return myPosition().getY() < 3215 && myPosition().getX() > 3228;
    }
    
    private void procedures() throws InterruptedException{
    	getCamera().toTop();
		if(getInventory().isItemSelected()){
			getInventory().deselectItem();
			sleep(random(200,400));
		}
		if(getSettings().getRunEnergy()>random(7,14)){
			getSettings().setRunning(true);
			sleep(random(200,400));
		}
	}

	private String ft(long duration) {
		String res = "";
		long days = TimeUnit.MILLISECONDS.toDays(duration);
		long hours = TimeUnit.MILLISECONDS.toHours(duration)
				- TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(duration));
		long minutes = TimeUnit.MILLISECONDS.toMinutes(duration)
				- TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
						.toHours(duration));
		long seconds = TimeUnit.MILLISECONDS.toSeconds(duration)
				- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
						.toMinutes(duration));
		if (days == 0L) {
			res = hours + ":" + minutes + ":" + seconds;
		} else {
			res = days + ":" + hours + ":" + minutes + ":" + seconds;
		}
		return res;
	}
}