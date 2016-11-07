// Generated from NPJ.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NPJParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		STRING_CONSTANT=10, INTEGER_CONSTANT=11, NULL=12, COMMENT=13, WS=14;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_vardeclaration = 2, RULE_assignment = 3, 
		RULE_lvalue = 4, RULE_rvalue = 5, RULE_printStringMessage = 6, RULE_printStringConstant = 7, 
		RULE_heapanalyze = 8, RULE_collect = 9, RULE_vardeclarationT = 10, RULE_vardeclarationSConst = 11, 
		RULE_vardeclarationSNull = 12;
	public static final String[] ruleNames = {
		"program", "statement", "vardeclaration", "assignment", "lvalue", "rvalue", 
		"printStringMessage", "printStringConstant", "heapanalyze", "collect", 
		"vardeclarationT", "vardeclarationSConst", "vardeclarationSNull"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "'='", "'.'", "'\"'", "'Print'", "'HeapAnalyze'", "'Collect'", 
		"'VarDeclT'", "'VarDeclS'", null, null, "'NULL'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "STRING_CONSTANT", 
		"INTEGER_CONSTANT", "NULL", "COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "NPJ.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NPJParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << STRING_CONSTANT))) != 0)) {
				{
				{
				setState(26);
				statement();
				}
				}
				setState(31);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public VardeclarationContext vardeclaration() {
			return getRuleContext(VardeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public PrintStringMessageContext printStringMessage() {
			return getRuleContext(PrintStringMessageContext.class,0);
		}
		public PrintStringConstantContext printStringConstant() {
			return getRuleContext(PrintStringConstantContext.class,0);
		}
		public HeapanalyzeContext heapanalyze() {
			return getRuleContext(HeapanalyzeContext.class,0);
		}
		public CollectContext collect() {
			return getRuleContext(CollectContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				vardeclaration();
				setState(33);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				assignment();
				setState(36);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(38);
				printStringMessage();
				setState(39);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				printStringConstant();
				setState(42);
				match(T__0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				heapanalyze();
				setState(45);
				match(T__0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
				collect();
				setState(48);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclarationContext extends ParserRuleContext {
		public VardeclarationTContext vardeclarationT() {
			return getRuleContext(VardeclarationTContext.class,0);
		}
		public VardeclarationSConstContext vardeclarationSConst() {
			return getRuleContext(VardeclarationSConstContext.class,0);
		}
		public VardeclarationSNullContext vardeclarationSNull() {
			return getRuleContext(VardeclarationSNullContext.class,0);
		}
		public VardeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterVardeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitVardeclaration(this);
		}
	}

	public final VardeclarationContext vardeclaration() throws RecognitionException {
		VardeclarationContext _localctx = new VardeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_vardeclaration);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(52);
				vardeclarationT();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				vardeclarationSConst();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				vardeclarationSNull();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public RvalueContext rvalue() {
			return getRuleContext(RvalueContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			lvalue(0);
			setState(58);
			match(T__1);
			setState(59);
			rvalue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode STRING_CONSTANT() { return getToken(NPJParser.STRING_CONSTANT, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitLvalue(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_lvalue, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(62);
			match(STRING_CONSTANT);
			}
			_ctx.stop = _input.LT(-1);
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LvalueContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
					setState(64);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(65);
					match(T__2);
					setState(66);
					match(STRING_CONSTANT);
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class RvalueContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode NULL() { return getToken(NPJParser.NULL, 0); }
		public TerminalNode INTEGER_CONSTANT() { return getToken(NPJParser.INTEGER_CONSTANT, 0); }
		public TerminalNode STRING_CONSTANT() { return getToken(NPJParser.STRING_CONSTANT, 0); }
		public RvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterRvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitRvalue(this);
		}
	}

	public final RvalueContext rvalue() throws RecognitionException {
		RvalueContext _localctx = new RvalueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rvalue);
		try {
			setState(78);
			switch (_input.LA(1)) {
			case STRING_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				lvalue(0);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				match(NULL);
				}
				break;
			case INTEGER_CONSTANT:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				match(INTEGER_CONSTANT);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				match(T__3);
				setState(76);
				match(STRING_CONSTANT);
				setState(77);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStringMessageContext extends ParserRuleContext {
		public TerminalNode STRING_CONSTANT() { return getToken(NPJParser.STRING_CONSTANT, 0); }
		public PrintStringMessageContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStringMessage; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterPrintStringMessage(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitPrintStringMessage(this);
		}
	}

	public final PrintStringMessageContext printStringMessage() throws RecognitionException {
		PrintStringMessageContext _localctx = new PrintStringMessageContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_printStringMessage);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__4);
			setState(81);
			match(T__3);
			setState(82);
			match(STRING_CONSTANT);
			setState(83);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStringConstantContext extends ParserRuleContext {
		public TerminalNode STRING_CONSTANT() { return getToken(NPJParser.STRING_CONSTANT, 0); }
		public PrintStringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterPrintStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitPrintStringConstant(this);
		}
	}

	public final PrintStringConstantContext printStringConstant() throws RecognitionException {
		PrintStringConstantContext _localctx = new PrintStringConstantContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_printStringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__4);
			setState(86);
			match(STRING_CONSTANT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeapanalyzeContext extends ParserRuleContext {
		public HeapanalyzeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_heapanalyze; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterHeapanalyze(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitHeapanalyze(this);
		}
	}

	public final HeapanalyzeContext heapanalyze() throws RecognitionException {
		HeapanalyzeContext _localctx = new HeapanalyzeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_heapanalyze);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CollectContext extends ParserRuleContext {
		public CollectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterCollect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitCollect(this);
		}
	}

	public final CollectContext collect() throws RecognitionException {
		CollectContext _localctx = new CollectContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_collect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__6);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclarationTContext extends ParserRuleContext {
		public TerminalNode STRING_CONSTANT() { return getToken(NPJParser.STRING_CONSTANT, 0); }
		public VardeclarationTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclarationT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterVardeclarationT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitVardeclarationT(this);
		}
	}

	public final VardeclarationTContext vardeclarationT() throws RecognitionException {
		VardeclarationTContext _localctx = new VardeclarationTContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_vardeclarationT);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__7);
			setState(93);
			match(STRING_CONSTANT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclarationSConstContext extends ParserRuleContext {
		public List<TerminalNode> STRING_CONSTANT() { return getTokens(NPJParser.STRING_CONSTANT); }
		public TerminalNode STRING_CONSTANT(int i) {
			return getToken(NPJParser.STRING_CONSTANT, i);
		}
		public VardeclarationSConstContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclarationSConst; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterVardeclarationSConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitVardeclarationSConst(this);
		}
	}

	public final VardeclarationSConstContext vardeclarationSConst() throws RecognitionException {
		VardeclarationSConstContext _localctx = new VardeclarationSConstContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_vardeclarationSConst);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__8);
			setState(96);
			match(STRING_CONSTANT);
			setState(97);
			match(T__3);
			setState(98);
			match(STRING_CONSTANT);
			setState(99);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VardeclarationSNullContext extends ParserRuleContext {
		public TerminalNode STRING_CONSTANT() { return getToken(NPJParser.STRING_CONSTANT, 0); }
		public TerminalNode NULL() { return getToken(NPJParser.NULL, 0); }
		public VardeclarationSNullContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardeclarationSNull; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).enterVardeclarationSNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NPJListener ) ((NPJListener)listener).exitVardeclarationSNull(this);
		}
	}

	public final VardeclarationSNullContext vardeclarationSNull() throws RecognitionException {
		VardeclarationSNullContext _localctx = new VardeclarationSNullContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_vardeclarationSNull);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(T__8);
			setState(102);
			match(STRING_CONSTANT);
			setState(103);
			match(NULL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\20l\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\3\2\7\2\36\n\2\f\2\16\2!\13\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\65\n\3\3"+
		"\4\3\4\3\4\5\4:\n\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6F\n\6\f"+
		"\6\16\6I\13\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7Q\n\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\2\3\n\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\2j\2\37"+
		"\3\2\2\2\4\64\3\2\2\2\69\3\2\2\2\b;\3\2\2\2\n?\3\2\2\2\fP\3\2\2\2\16R"+
		"\3\2\2\2\20W\3\2\2\2\22Z\3\2\2\2\24\\\3\2\2\2\26^\3\2\2\2\30a\3\2\2\2"+
		"\32g\3\2\2\2\34\36\5\4\3\2\35\34\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37"+
		" \3\2\2\2 \3\3\2\2\2!\37\3\2\2\2\"#\5\6\4\2#$\7\3\2\2$\65\3\2\2\2%&\5"+
		"\b\5\2&\'\7\3\2\2\'\65\3\2\2\2()\5\16\b\2)*\7\3\2\2*\65\3\2\2\2+,\5\20"+
		"\t\2,-\7\3\2\2-\65\3\2\2\2./\5\22\n\2/\60\7\3\2\2\60\65\3\2\2\2\61\62"+
		"\5\24\13\2\62\63\7\3\2\2\63\65\3\2\2\2\64\"\3\2\2\2\64%\3\2\2\2\64(\3"+
		"\2\2\2\64+\3\2\2\2\64.\3\2\2\2\64\61\3\2\2\2\65\5\3\2\2\2\66:\5\26\f\2"+
		"\67:\5\30\r\28:\5\32\16\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2:\7\3\2\2\2"+
		";<\5\n\6\2<=\7\4\2\2=>\5\f\7\2>\t\3\2\2\2?@\b\6\1\2@A\7\f\2\2AG\3\2\2"+
		"\2BC\f\3\2\2CD\7\5\2\2DF\7\f\2\2EB\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2"+
		"\2H\13\3\2\2\2IG\3\2\2\2JQ\5\n\6\2KQ\7\16\2\2LQ\7\r\2\2MN\7\6\2\2NO\7"+
		"\f\2\2OQ\7\6\2\2PJ\3\2\2\2PK\3\2\2\2PL\3\2\2\2PM\3\2\2\2Q\r\3\2\2\2RS"+
		"\7\7\2\2ST\7\6\2\2TU\7\f\2\2UV\7\6\2\2V\17\3\2\2\2WX\7\7\2\2XY\7\f\2\2"+
		"Y\21\3\2\2\2Z[\7\b\2\2[\23\3\2\2\2\\]\7\t\2\2]\25\3\2\2\2^_\7\n\2\2_`"+
		"\7\f\2\2`\27\3\2\2\2ab\7\13\2\2bc\7\f\2\2cd\7\6\2\2de\7\f\2\2ef\7\6\2"+
		"\2f\31\3\2\2\2gh\7\13\2\2hi\7\f\2\2ij\7\16\2\2j\33\3\2\2\2\7\37\649GP";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}