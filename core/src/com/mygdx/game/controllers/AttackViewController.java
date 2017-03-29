package com.mygdx.game.controllers;


import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class AttackViewController extends ViewController{

    private Table popup;

    public AttackViewController(){
        super();
        money = "10000";
        setUpPopupTable();
        fillTable();
        doneButton.setText("Done!");
    }

    private void setUpPopupTable(){
        popup = new Table();
        popup.add().top().left();
        popup.add();
        popup.add().right();
        popup.setBounds(g.getScreenWidth()/10,g.getScreenHeight()/3*2,g.getScreenWidth()*8/10,g.getScreenHeight()/4);
        popup.debug();
    }

    private void setUpPopup() {
        System.out.println(tableCells.indexOf(chosenCell,true));

    }

    @Override
    public void create() {

    }

    @Override
    public void findPressedCell(float x, float y){
        super.findPressedCell(x,y);
        setUpPopup();
    }

    public void fillTable(){
        addStuffToTable(g.getAttackers(),g.getQuestionMarkMex());
    }

    public void left(){
        decreaseListIndex(g.getAttackers(),g.getQuestionMarkMex());
    }

    public void right(){
        increaseListIndex(g.getAttackers(),g.getQuestionMarkMex());
    }

    public Table getPopup() {
        return popup;
    }
}

