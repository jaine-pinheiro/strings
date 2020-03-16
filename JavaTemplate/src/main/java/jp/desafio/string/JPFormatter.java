package jp.desafio.string;

public class JPFormatter extends StringFormatter {


private static final String DELIMITER_NEW_LINE =" #$# ";
	
	public JPFormatter(){} 
	
	public JPFormatter(int limit, boolean justify) {
		super.setLimit(limit);
		super.setJustify(justify);
	}	
	
    @Override
    public StringBuilder format(String text) {
    	// count of characteres of currentWord e currentLine
    	Integer totalLenghOfCurrentWordAndLine = 0;
    	// value of current word
    	StringBuilder currentWord = new StringBuilder();
    	// value of current line
		StringBuilder currentLine = new StringBuilder();
		// final result 
		StringBuilder textResult = new StringBuilder();
		
		// replacing text by wildCard DELIMITER_NEW_LINE and split text by " "
		String [] textArray =  text.replace("\n",DELIMITER_NEW_LINE).split("\\s");
		
		for (String eachword: textArray) {
			currentWord.append(eachword);
			totalLenghOfCurrentWordAndLine = (currentLine.length()) + (currentWord.length()); 
			// if current word is a wildCard we must add new line
			if(isCreateNewLine(currentWord)){
				addNewLine(currentLine, textResult);
				cleanCurrentWord(currentWord);
				cleanCurrentLine(currentLine);
				continue;
			}
			
			if(currentLine.length() <= getLimit() && totalLenghOfCurrentWordAndLine <= getLimit()){
				currentWord.append(" ");
				currentLine.append(currentWord);
				cleanCurrentWord(currentWord);
			}else{
				addNewLine(currentLine, textResult);
				cleanCurrentLine(currentLine);
				currentLine.append(currentWord.append(" "));
				cleanCurrentWord(currentWord);
			}
			
			totalLenghOfCurrentWordAndLine = 0;
		}
		textResult.append(currentLine);
		return textResult;
    }

	private boolean isCreateNewLine(StringBuilder currentWord) {
		return DELIMITER_NEW_LINE.trim().contentEquals(currentWord);
	}
    
	private static void addNewLine(StringBuilder currentLine, StringBuilder result) {
		result.append(currentLine.append("\n"));
	}
	private static void cleanCurrentWord(StringBuilder currentWord) {
		currentWord.delete(0, currentWord.length());
	}
	private static void cleanCurrentLine(StringBuilder currentLine) {
		currentLine.delete(0, currentLine.length());
	}
    
}
