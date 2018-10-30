
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stddef.h>
#include "dll.h"


CADDLL void salvarAluno(char *nome,char *matricula,char *curso)// 3 strings oa inves de um struct
{
    FILE *arq;
    arq = fopen("rick.txt", "a");  // Cria um arquivo texto para gravação
    if (arq == NULL)               // Se nào conseguiu criar exibe a mensagem e não cria
    {
        printf("Problemas na CRIACAO do arquivo\n");
        return;
    }
    fprintf(arq,"%s, %s, %s.\n",nome, matricula, curso); //Armazena o tamanho do vetor auxiliar
	//fprintf(arq,"%s, %s, %s.\n",aluno.nome, aluno.matricula, aluno.curso); //Armazena o tamanho do vetor auxiliar

    fclose(arq);
    printf("\n\n\nValores salvos com sucesso.\n");

}

CADDLL void recuperarAluno(char *nome)
{
    char alunorecuperado[40];
    char tmp[100];

    FILE* arq;

    arq = fopen("rick.txt", "r");
    // Cria um arquivo texto para leitura

    if (arq == NULL)               // Se nào conseguiu criar exibe a mensagem e não cria
    {
        printf("Problemas na RECUPERACAO do arquivo\n");
        return;
    }

    printf("Pesquisando por: %s",nome);


    while( !feof(arq) )
    {

        fgets( tmp, 100, arq );

        if (strstr(tmp, nome))
        {
            printf("\n\n");
            printf(tmp);
            printf("\n\nAluno encontrado\n\n");
            fclose(arq);

            return;
        }

    }

    fclose(arq);

    printf("\n\nAluno nao cadastrado\n\n");

}

CADDLL void apagaAluno (char *nome){
	char tmp[100];
	FILE *pTemp;
    pTemp = fopen("Temp.txt", "w+");

//abre o arquivo atual
	FILE *arq;
	arq=fopen("rick.txt","r");

//passaa todos os registros para o arquivo temporario exceto o atual 
 	while( !feof(arq) )
    {

        fgets( tmp, 100, arq );

        if (!strstr(tmp, nome))
			fprintf(pTemp,tmp);

	}

	fclose(arq);
	fclose(pTemp);

//remove o arquivo atual e renomeia o temporario para o nome do arquivo original
	remove("rick.txt");
	rename("Temp.txt", "rick.txt");
	printf("\n\nAluno apagado\n\n");
}





