/*
Given a dictionary of millions of words, give an algorithm to find the largest possible
 rectangle of letters such that every row forms a word (reading left to right) and every column forms a word (reading top to bottom).

 译文：
 有百万个单词的字典，给一个算法找出最大可能的字母矩形使每行（从左到右）和每列（从上到下）形成一个单词。

 解答
 ctci解法：
 许多问题包含字典可以通过预处理被解决。但如何预处理？
 好的，如果我们将要创建矩形单词，我们知道每行必须同样长度，每列也必须同样长度。所以，让我们基于单词的长度将字典里面的单词分为不同组。我们调用单词组D,在D[i]提供一列长度为i的单词。
 接下来，观察我们找出最长的矩形，绝对值最大的矩形可能就形成了？它是（最大长度的单词）*（最大长度的单词）

	int max_rectangle = longest_word * longest_word;
	for z = max_rectangle to 1 {
		for each pair of numbers (i, j) where i*j = z {
			// attempt to make rectangle. return if successful. 
		}
	}

通过按照这个顺序遍历，我们保证找到的第一个矩形是最大的
现在最难的部分：make_rectangle,我们的下一步是按行重新排列在列表1的单词，并检查在列表2的列的单词是否有效。
然后，创建一个特殊的10x20的矩阵，我们再检查是否列已经在前两个单词就被创造，一个单词查找树就很容易得到。

*/
class Q20_13{
	public static void main(String[] args){

	}
}

WordGroup[] groupList = WordGroup.createWordGroups(list);
private int maxWordLength = groupList.length;
private Trie trieList[] = new Trie[maxWordLength];

public Rectangle maxRectangle() {
	int maxSize = maxWordLength * maxWordLength;
	for (int z = maxSize; z > 0; z--) {
		for (int i = 1; i <= maxWordLength; i ++ ) {
			if (z % i == 0) {
				int j = z / i;
				if (j <= maxWordLength) {
					Rectangle rectangle = makeRectangle(i,j);
					if (rectangle != null) {
						return rectangle;
					}
				}
			}
		}
	}
	return null;
}
	
private Rectangle makeRectangle(int length, int height) {
	if (groupList[length - 1] == null || groupList[height - 1] == null) {
		return null;
	}
	if (trieList[height - 1] == null) {
		LinkedList<String> words = groupList[height - 1].getWords();
		trieList[height - 1] = new Trie(words);
	}
	return makePartialRectangle(length, height, new Rectangle(length));
}
	
private Rectangle makePartialRectangle(int l, int h, Rectangle rectangle) {
	if (rectangle.height == h) { // Check if complete rectangle
		if (rectangle.isComplete(l, h, groupList[h - 1])) {
			return rectangle;
		} else {
			return null;
		}
	}
	
	// Compare columns to trie to see if potentially valid rect */
	if (!rectangle.isPartialOK(l, trieList[h - 1])) return null;
	
	for (int i = 0; i < groupList[l-1].length(); i++) {
		Rectangle org_plus = rectangle.append(groupList[l-1].getWord(i));
		Rectangle rect = makePartialRectangle(l, h, org_plus);
		if (rect != null) {
			return rect;
		}
	}
	return null;
}