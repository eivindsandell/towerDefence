package com.mygdx.game.controllers;


import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.mygdx.game.models.mobs.Mob;

public class AttackViewController extends ViewController{

    private Mob currentChosenMob;
    private Table popup;
    private Integer chosenQuantity;
    private TextButton add;
    private TextButton subtract;
    private Label quantityLabel;
    private TextButton purchase;

    public AttackViewController(){
        super();
        money = 1000;
        popup = new Table();
        popup.setClip(true);
        add = new TextButton("+",g.getTextButtonStyle());
        subtract = new TextButton("-",g.getTextButtonStyle());
        purchase = new TextButton("Buy",g.getTextButtonStyle());
        chosenQuantity = 0;
        currentChosenMob = null;
        quantityLabel = null;
        fillTable();
        doneButton.setText("Done!");
    }


    @Override
    public void create() {

    }

    public void updatePopupTable(){
        if(popup.hasChildren() && chosenCell!=null){
            paintPopup();
            return;
        }
        if(chosenCell!=null && !popup.hasChildren()){
            //popup.debug();
            popup.setBounds(g.getScreenWidth()/10,boardGrid.getY(),g.getScreenWidth()*8/10,g.getScreenHeight()-boardGrid.getY());
            currentChosenMob = g.whichMob(listIndex+tableCells.indexOf(chosenCell,true));
            quantityLabel = new Label(chosenQuantity.toString(),g.getLabelStyle());

            popup.add(new Image(g.getMobTextures().get(listIndex+tableCells.indexOf(chosenCell,true)))).width(popup.getWidth()/4).height(popup.getHeight()/5).colspan(3);
            popup.row();
            // add description here:
            popup.add().height(popup.getHeight()/5).width(popup.getWidth()).colspan(3);
            //
            popup.row();
            popup.add(new Label("Unit Cost",g.getLabelStyle())).width(popup.getWidth()/2).height(popup.getHeight()/5);
            popup.add(new Label(currentChosenMob.getPrice().toString(),g.getLabelStyle())).width(popup.getWidth()/4).height(popup.getHeight()/5);
            popup.add(add).width(popup.getWidth()/4).height(popup.getHeight()/5);
            popup.row();
            popup.add(new Label("Quantity",g.getLabelStyle())).width(popup.getWidth()/2).height(popup.getHeight()/5);
            popup.add(quantityLabel).width(popup.getWidth()/4).height(popup.getHeight()/5);
            popup.add(subtract).width(popup.getWidth()/4).height(popup.getHeight()/5);
            popup.row();
            popup.add(purchase).colspan(3).height(popup.getHeight()/5).width(popup.getWidth());
            paintPopup();
        }
        else{
            popup.clearChildren();
        }
    }

    @Override
    public void findPressedCell(float x, float y){
        super.findPressedCell(x,y);
        if(chosenCell==null){
            money += (chosenQuantity*currentChosenMob.getPrice());
            chosenQuantity = 0;
        }
    }

    public void fillTable(){
        addStuffToTable(g.getMobTextures(),g.getQuestionMarkMex());
    }

    public void left(){
        decreaseListIndex(g.getMobTextures(),g.getQuestionMarkMex());
    }

    public void right(){
        increaseListIndex(g.getMobTextures(),g.getQuestionMarkMex());
    }

    public Table getPopup() {
        return popup;
    }

    public void paintPopup() {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(0,0,0,1);
        sr.rect(popup.getX(),popup.getY(),popup.getWidth(),popup.getHeight());
        sr.end();
    }
    public TextButton getAdd() {
        return add;
    }
    public TextButton getSubtract() {
        return subtract;
    }

    public void add() {
        if(popup.hasChildren()) {
            if(money >= currentChosenMob.getPrice()){
                chosenQuantity++;
                money -= currentChosenMob.getPrice();
                quantityLabel.setText(chosenQuantity.toString());
            }
        }
    }
    public void subtract(){
        if(popup.hasChildren()&&chosenQuantity!=0) {
            chosenQuantity--;
            money += currentChosenMob.getPrice();
            quantityLabel.setText(chosenQuantity.toString());
        }
    }

    public TextButton getPurchase() {
        return purchase;
    }

    public void buy() {
        for(int i=0;i<chosenQuantity;i++){
            board.addMobToQueue(g.whichMob(listIndex+tableCells.indexOf(chosenCell,true)));
        }
        chosenCell = null;
        currentChosenMob = null;
        chosenQuantity = 0;
    }
}

