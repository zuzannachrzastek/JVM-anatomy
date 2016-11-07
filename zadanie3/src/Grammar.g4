grammar NPJ;

STRING_CONSTANT:    [a-zA-Z][a-zA-Z0-9]*;

INTEGER_CONSTANT:   '0' | [1-9][0-9]* ;

program: statement+;

statement:  /* epsilon */
         |  vardeclaration';'
         |  assignment';'
         |  'Print' '"' STRING_CONSTANT '"'';'
         |  'Print' STRING_CONSTANT';'
         |  'HeapAnalyze'';'
         |  'Collect'';'
         ;

vardeclaration: 'VarDeclT' STRING_CONSTANT
              | 'VarDeclS' STRING_CONSTANT '"' STRING_CONSTANT '"'
              | 'VarDeclS' STRING_CONSTANT 'NULL'
              ;

assignment: lvalue '=' rvalue;

lvalue: STRING_CONSTANT
      | lvalue'.'STRING_CONSTANT
      ;

rvalue: lvalue
      | 'NULL'
      | INTEGER_CONSTANT
      | '"' STRING_CONSTANT '"'
      ;

COMMENT : '//' .+? ('\n'|EOF) -> skip ;

WS:   [ \t\n\r]+ -> skip ;