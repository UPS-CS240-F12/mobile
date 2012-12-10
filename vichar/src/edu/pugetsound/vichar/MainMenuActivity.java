package edu.pugetsound.vichar;

import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.ScaleDrawable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.content.Context;

/**
 * Activity for the main menu screen, contains buttons to navigate to other 
 * important screens.
 * @author Davis Shurbert
 *
 */
public class MainMenuActivity extends Activity {
	final Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //help with banding on gradients
        getWindow().setFormat(PixelFormat.RGBA_8888);
        
        setContentView(R.layout.activity_main_menu);
        
        createButtons();

            
    }
    
    private void createButtons() {
    	Button anib = (Button)findViewById(R.id.button_animation); //declaring the button
        anib.setOnClickListener(animationListener); //making the thing that checks if the button's been pushed
        
        Button gameb = (Button)findViewById(R.id.game_button); //declaring the button
        gameb.setOnClickListener(gameListener); //making the thing that checks if the button's been pushed
        
        
            //animation on play button
            final AlphaAnimation animation = new AlphaAnimation(1, (float) .2); // Change alpha from fully visible to invisible
            animation.setDuration(1000); // duration - half a second
            animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
            animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
            animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
            anib.startAnimation(animation);
            

        
        Button mainb = (Button)findViewById(R.id.about_button); //declaring the button
        mainb.setOnClickListener(aboutListener); //making the thing that checks if the button's been pushed
        
        Button leaderboardb = (Button)findViewById(R.id.leaderboard_button); 
        leaderboardb.setOnClickListener(leaderboardListener);
        
        Button rulesb = (Button)findViewById(R.id.rules_button); 
        rulesb.setOnClickListener(rulesListener);
        
        Button settingsb = (Button)findViewById(R.id.settings_button); 
        settingsb.setOnClickListener(settingsListener);
    }
    
    private OnClickListener settingsListener = new OnClickListener() { //sets what happens when the button is pushed
    	public void onClick(View v) { 
        	
    		startActivity(new Intent(context, SettingsActivity.class));
        }
       };
       
    private OnClickListener rulesListener = new OnClickListener() { //sets what happens when the button is pushed
    	public void onClick(View v) { 
        	
    		startActivity(new Intent(context, RulesActivity.class));
        }
       };
       
    private OnClickListener leaderboardListener = new OnClickListener() { //sets what happens when the button is pushed
    	public void onClick(View v) { 
        	
    		startActivity(new Intent(context, LeaderboardActivity.class));
        }
       };
       
    private OnClickListener animationListener = new OnClickListener() { //sets what happens when the button is pushed
    	public void onClick(View v) { 
    	    v.clearAnimation();
    		startActivity(new Intent(context, GameActivity.class));
        }
       };
       
       private OnClickListener gameListener = new OnClickListener() { //sets what happens when the button is pushed
           public void onClick(View v) { 
               startActivity(new Intent(context, GameActivity.class));
           }
          };
    private OnClickListener aboutListener = new OnClickListener() { //sets what happens when the button is pushed
    	public void onClick(View v) { 
        	
    		startActivity(new Intent(context, AboutActivity.class));
        }
       };
       

       @Override
       public boolean onCreateOptionsMenu(Menu menu) {
           getMenuInflater().inflate(R.menu.activity_main_menu, menu);
           return true;
       }
}
