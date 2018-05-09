package com.lv77android.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int CIRCIL = 1;

    private static int CROSS = 2;

    private static String CIRCIL_STR = "Circle O";

    private static String CROSS_STR = "Cross X";
    private int side;
    private int lastPlacedSide;
    private String sideStr;

    private JiuGongGe panel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.panel = new JiuGongGe();
        panel.resetJiuGongGe();
        this.side = CIRCIL;
        this.sideStr = CIRCIL_STR;
    }

    public void changeSide(View view) {

        if(panel.isFull()){
            Toast.makeText(MainActivity.this, "Ah-Oh! We " +
                    "ran out of space! Please reset the game. ", Toast.LENGTH_SHORT).show();
        }

        if (side != lastPlacedSide) {
            Toast.makeText(MainActivity.this, "You haven't made " +
                    "your move yet.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (panel.hasWinner) {
            Toast.makeText(MainActivity.this, "Game finished." +
                    " Please reset to re-play.", Toast.LENGTH_SHORT).show();
            return;
        }

        TextView sideLabel = findViewById(R.id.side_l);
        switch (side) {
            case 1: {
                side = CROSS;
                sideStr = CROSS_STR;
                sideLabel.setText(CROSS_STR);
                Toast.makeText(MainActivity.this,
                        "It's Circle's turn.", Toast.LENGTH_SHORT).show();
            }
            break;
            case 2: {
                side = CIRCIL;
                sideStr = CIRCIL_STR;
                sideLabel.setText(CIRCIL_STR);
                Toast.makeText(MainActivity.this,
                        "Cross's turn.", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
        }

    }


    public void placeElement(View view) {

        if(panel.isFull()){
            Toast.makeText(MainActivity.this, "Ah-Oh! We " +
                    "ran out of space! Please reset the game. ", Toast.LENGTH_SHORT).show();
        }

        if (panel.hasWinner) {
            Toast.makeText(MainActivity.this, "Game finished." +
                    " Please reset to re-play.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (side == lastPlacedSide) {
            Toast.makeText(MainActivity.this, "Please switch " +
                    "side! One only got one move per round!", Toast.LENGTH_SHORT).show();
            return;
        }

        ImageView round = null;
        ImageView cross = null;

        switch (view.getId()) {
            case R.id.row1_left:
                // do your code
                if (panel.R1_1 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row1_left_r);
                    cross = findViewById(R.id.row1_left_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R1_1 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R1_1 = CROSS;
                    }
                }
                break;
            case R.id.row1_center:
                if (panel.R1_2 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row1_center_r);
                    cross = findViewById(R.id.row1_center_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R1_2 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R1_2 = CROSS;
                    }
                }
                break;
            case R.id.row1_right:
                if (panel.R1_3 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row1_right_r);
                    cross = findViewById(R.id.row1_right_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R1_3 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R1_3 = CROSS;
                    }
                }
                break;
            case R.id.row2_left:
                if (panel.R2_1 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row2_left_r);
                    cross = findViewById(R.id.row2_left_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R2_1 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R2_1 = CROSS;
                    }
                }
                break;
            case R.id.row2_center:
                if (panel.R2_2 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row2_center_r);
                    cross = findViewById(R.id.row2_center_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R2_2 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R2_2 = CROSS;
                    }
                }
                break;
            case R.id.row2_right:
                if (panel.R2_3 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row2_right_r);
                    cross = findViewById(R.id.row2_right_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R2_3 = 1;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R2_3 = 2;
                    }
                }
                break;
            case R.id.row3_left:
                if (panel.R3_1 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row3_left_r);
                    cross = findViewById(R.id.row3_left_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R3_1 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R3_1 = CROSS;
                    }
                }
                break;
            case R.id.row3_center:
                if (panel.R3_2 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row3_center_r);
                    cross = findViewById(R.id.row3_center_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R3_2 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R3_2 = CROSS;
                    }
                }
                break;
            case R.id.row3_right:
                if (panel.R3_3 != 0) {
                    showPlaceTakenMessage(view);
                    return;
                } else {
                    round = findViewById(R.id.row3_right_r);
                    cross = findViewById(R.id.row3_right_c);
                    if (side == CIRCIL) {
                        crossOutCircleIn(round, cross);
                        panel.R3_3 = CIRCIL;
                    } else if (side == CROSS) {
                        crossInCircleOut(round, cross);
                        panel.R3_3 = CROSS;
                    }
                }
                break;
            default:
                break;
        }

        Log.i("PANEL", panel.print());
        int result = panel.checkSuccess();
        if (result > 0) {
            Toast.makeText(MainActivity.this, "Woo-hoo! We " +
                    "have a winner! " + this.sideStr + "!", Toast.LENGTH_LONG).show();
        }

        if(result == 0 && panel.isFull()){
            Toast.makeText(MainActivity.this, "Ah-Oh! We " +
                    "ran out of space! Please reset the game. ", Toast.LENGTH_SHORT).show();
        }

        lastPlacedSide = side;
        return;
    }

    private void crossOutCircleIn(ImageView round, ImageView cross) {
        cross.setVisibility(View.INVISIBLE);
        round.setTranslationZ(-10);
        round.setScaleX(10f);
        round.setScaleY(10f);
        round.setVisibility(View.VISIBLE);
        round.animate().z(0).scaleX(1).scaleY(1).setDuration(300);
    }
    private void crossInCircleOut(ImageView round, ImageView cross) {
        round.setVisibility(View.INVISIBLE);
        cross.setTranslationZ(-10);
        cross.setScaleX(10f);
        cross.setScaleY(10f);
        cross.setVisibility(View.VISIBLE);
        cross.animate().z(0).scaleX(1).scaleY(1).setDuration(300);
    }
    private void showPlaceTakenMessage(View view) {
        Toast.makeText(MainActivity.this, "This place is " +
                "already taken! Please find an empty space or pass on to " +
                "next player", Toast.LENGTH_SHORT).show();
    }

    public void resetGrid(View view) {

        //Reset Side
        side = CIRCIL;
        TextView sideLabel = findViewById(R.id.side_l);
        sideLabel.setText(CIRCIL_STR);

        ImageView r1_1r = findViewById(R.id.row1_left_r);
        ImageView r1_1c = findViewById(R.id.row1_left_c);
        ImageView r1_2r = findViewById(R.id.row1_center_r);
        ImageView r1_2c = findViewById(R.id.row1_center_c);
        ImageView r1_3r = findViewById(R.id.row1_right_r);
        ImageView r1_3c = findViewById(R.id.row1_right_c);


        ImageView r2_1r = findViewById(R.id.row2_left_r);
        ImageView r2_1c = findViewById(R.id.row2_left_c);
        ImageView r2_2r = findViewById(R.id.row2_center_r);
        ImageView r2_2c = findViewById(R.id.row2_center_c);
        ImageView r2_3r = findViewById(R.id.row2_right_r);
        ImageView r2_3c = findViewById(R.id.row2_right_c);


        ImageView r3_1r = findViewById(R.id.row3_left_r);
        ImageView r3_1c = findViewById(R.id.row3_left_c);
        ImageView r3_2r = findViewById(R.id.row3_center_r);
        ImageView r3_2c = findViewById(R.id.row3_center_c);
        ImageView r3_3r = findViewById(R.id.row3_right_r);
        ImageView r3_3c = findViewById(R.id.row3_right_c);

        r1_1r.setVisibility(View.INVISIBLE);
        r1_1c.setVisibility(View.INVISIBLE);
        r1_2r.setVisibility(View.INVISIBLE);
        r1_2c.setVisibility(View.INVISIBLE);
        r1_3r.setVisibility(View.INVISIBLE);
        r1_3c.setVisibility(View.INVISIBLE);

        r2_1r.setVisibility(View.INVISIBLE);
        r2_1c.setVisibility(View.INVISIBLE);
        r2_2r.setVisibility(View.INVISIBLE);
        r2_2c.setVisibility(View.INVISIBLE);
        r2_3r.setVisibility(View.INVISIBLE);
        r2_3c.setVisibility(View.INVISIBLE);

        r3_1r.setVisibility(View.INVISIBLE);
        r3_1c.setVisibility(View.INVISIBLE);
        r3_2r.setVisibility(View.INVISIBLE);
        r3_2c.setVisibility(View.INVISIBLE);
        r3_3r.setVisibility(View.INVISIBLE);
        r3_3c.setVisibility(View.INVISIBLE);

        this.panel.resetJiuGongGe();
        this.side = CIRCIL;
        this.lastPlacedSide = 0;
    }

    private class JiuGongGe {

        private int EMPTY = 0;

        private int CIRCIL = 1;

        private int CROSS = 2;

        public int R1_1;
        public int R1_2;
        public int R1_3;
        public int R2_1;
        public int R2_2;
        public int R2_3;
        public int R3_1;
        public int R3_2;
        public int R3_3;
        public boolean hasWinner;

        public void resetJiuGongGe() {
            this.R1_1 = 0;
            this.R1_2 = 0;
            this.R1_3 = 0;
            this.R2_1 = 0;
            this.R2_2 = 0;
            this.R2_3 = 0;
            this.R3_1 = 0;
            this.R3_2 = 0;
            this.R3_3 = 0;
            this.hasWinner = false;
            Log.i("PANEL", print());
        }

        /**
         * return 0 means no success
         * return 1 means circle wins
         * return 2 means cross wins
         */
        public int checkSuccess() {
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{R1_1, R1_2, R1_3});
            list.add(new int[]{R1_1, R2_2, R3_3});
            list.add(new int[]{R2_1, R2_2, R2_3});
            list.add(new int[]{R3_1, R3_2, R3_3});
            list.add(new int[]{R3_1, R2_2, R1_3});
            list.add(new int[]{R3_1, R2_1, R1_1});
            list.add(new int[]{R3_2, R2_2, R1_2});
            list.add(new int[]{R3_3, R2_3, R1_3});

            for (int[] ec : list) {
                if (ec[0] == ec[1] && ec[1] == ec[2] && ec[0] != EMPTY) {
                    hasWinner = true;
                    return ec[0];
                }
            }

            return 0;
        }

        public String print(){
            return R1_1 + ", " + R1_2 + ", " + R1_3 + "\n"
                    + R2_1 + ", " + R2_2 + ", " + R2_3 + "\n"
                    + R3_1 + ", " + R3_2 + ", " + R3_3;
        }

        public boolean isFull() {
            if (R1_2 == EMPTY || R1_1 == EMPTY || R1_3 == EMPTY
                    || R2_2 == EMPTY || R2_1 == EMPTY || R2_3 == EMPTY
                    || R3_2 == EMPTY || R3_1 == EMPTY || R3_3 == EMPTY) {
                return false;
            }
            return true;
        }
    }

}
