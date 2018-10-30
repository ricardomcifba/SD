
#include <stdio.h>
#include <stdlib.h>
#include <windows.h>


#define SIZEOF_ARRAY( a ) (sizeof( a ) / sizeof( a[ 0 ] ))

struct Cadastro {
    char nome[40];
    char matricula [20];
    char curso[20];
};

typedef void (WINAPI *callback)();
callback funcaoTemp;

int main(int argc, char** argv) {

	HINSTANCE hLib = LoadLibrary("AlunoDLL.dll");

	if (!hLib) { printf("error"); return 0; }

    struct Cadastro aluno;
	int op = 0;
    do {

    	printf("Digite 1 para Novo Cadastro \n");
        printf("Digite 2 para Recuperar Cadastro \n");
        printf("Digite 3 para Apagar Cadastro  \n");
        printf("0  para sair: ");
		scanf("%d", &op);
		if(op >0 || op<4 ){
	    	switch(op)
	        {
	            case 1:
	                printf("\nCadastro de Alunos\n\n");

			        printf("\nDigite o nome do aluno: ");
			        scanf(" %s", aluno.nome);
			        fflush(stdin);
			        printf("\nDigite a matricula do aluno: ");
			        scanf("%s", aluno.matricula);
			        fflush(stdin);
			        printf("\nDigite o curso do aluno: ");
			        scanf("%s", aluno.curso);
			        fflush(stdin);
			        funcaoTemp = (callback) GetProcAddress((HMODULE)hLib, "salvarAluno");
			        funcaoTemp(aluno.nome,aluno.matricula,aluno.curso);
			        break;
	        	case 2:
	                printf("\nPesquisar Aluno\n\n");
			        printf("\nDigite o nome do aluno: ");
			        scanf(" %s", aluno.nome);
			        funcaoTemp = (callback) GetProcAddress((HMODULE)hLib, "recuperarAluno");
			        funcaoTemp(aluno.nome);
			        break;
	            case 3:
	                printf("\nApagar Aluno\n\n");
			        printf("\nDigite o nome do aluno: ");
			        scanf(" %s", aluno.nome);
			        funcaoTemp = (callback) GetProcAddress((HMODULE)hLib, "apagaAluno");
			        funcaoTemp(aluno.nome);
	                break;
	        }

		}else{
			printf("Opcao invalida \n ");
			printf("Digite 1 para Novo Cadastro \n ");
	        printf("Digite 2 para Recuperar Cadastro \n");
	        printf("Digite 3 para Apagar Cadastro  \n");
	        printf("0  para sair: ");
			scanf("%d", &op);
		}
 	}while (op!=0);

          return 0;

}






