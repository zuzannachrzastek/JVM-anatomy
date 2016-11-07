grammar NPJ;

STRING_CONSTANT:    [a-zA-Z][a-zA-Z0-9]*;

INTEGER_CONSTANT:   '0' | [1-9][0-9]* ;

NULL: 'NULL';

program: statement*;

statement:  vardeclaration';'
         |  assignment';'
         |  printStringMessage';'
         |  printStringConstant';'
         |  heapanalyze';'
         |  collect';'
         ;

vardeclaration: vardeclarationT
              | vardeclarationSConst
              | vardeclarationSNull
              ;

assignment: lvalue '=' rvalue;

lvalue: STRING_CONSTANT
      | lvalue'.'STRING_CONSTANT
      ;

rvalue: lvalue
      | NULL
      | INTEGER_CONSTANT
      | '"' STRING_CONSTANT '"'
      ;

printStringMessage: 'Print' '"' STRING_CONSTANT '"';

printStringConstant: 'Print' STRING_CONSTANT;

heapanalyze: 'HeapAnalyze';

collect: 'Collect';

vardeclarationT: 'VarDeclT' STRING_CONSTANT;

vardeclarationSConst: 'VarDeclS' STRING_CONSTANT '"' STRING_CONSTANT '"';

vardeclarationSNull: 'VarDeclS' STRING_CONSTANT NULL;

COMMENT : '//' .+? ('\n'|EOF) -> skip ;

WS:   [ \t\n\r]+ -> skip ;