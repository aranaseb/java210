package model;

// Choice is an enum to be used in class GameTree as an argument to this method
//
//   public void playerSelected(Choice yesOrNo) 
// 
// This helps avoid problems when a string or char is used with issues like 
// case sensitivity or extra blanks
//
// Sample code:
// 
//  Choice userSelection = Choice.Yes;
//
//  if(yesOrNo == Choice.YES)
// 
// @author Rick Mercer
//
public enum Choice {
  YES, NO
};

