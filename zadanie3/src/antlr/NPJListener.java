// Generated from NPJ.g4 by ANTLR 4.5.3
package antlr;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link NPJParser}.
 */
public interface NPJListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link NPJParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(NPJParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPJParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(NPJParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link NPJParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(NPJParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPJParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(NPJParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link NPJParser#vardeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVardeclaration(NPJParser.VardeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPJParser#vardeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVardeclaration(NPJParser.VardeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link NPJParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(NPJParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPJParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(NPJParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link NPJParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void enterLvalue(NPJParser.LvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPJParser#lvalue}.
	 * @param ctx the parse tree
	 */
	void exitLvalue(NPJParser.LvalueContext ctx);
	/**
	 * Enter a parse tree produced by {@link NPJParser#rvalue}.
	 * @param ctx the parse tree
	 */
	void enterRvalue(NPJParser.RvalueContext ctx);
	/**
	 * Exit a parse tree produced by {@link NPJParser#rvalue}.
	 * @param ctx the parse tree
	 */
	void exitRvalue(NPJParser.RvalueContext ctx);
}