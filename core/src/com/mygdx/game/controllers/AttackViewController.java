package com.mygdx.game.controllers;


import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class AttackViewController extends ViewController{

    private Table popup;

    public AttackViewController(){
        super();
        money = "10000";
        popup = new Table();
        updatePopupTable();
        fillTable();
        doneButton.setText("Done!");
    }

    public void updatePopupTable(){
        if(popup.hasChildren() && chosenCell!=null){
            return;
        }
        if(chosenCell!=null && !popup.hasChildren()){
            popup.add(new Image(g.getMobTextures().get(listIndex+tableCells.indexOf(chosenCell,true)))).top().left();
            popup.add();
            popup.add().right();
            popup.setBounds(g.getScreenWidth()/10,g.getScreenHeight()/3*2,g.getScreenWidth()*8/10,g.getScreenHeight()/4);

        }
        else{
            popup.clearChildren();
        }
    }


    @Override
    public void create() {

    }

    @Override
    public void findPressedCell(float x, float y){
        super.findPressedCell(x,y);
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
}

