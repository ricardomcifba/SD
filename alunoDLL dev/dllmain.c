
#include <stdio.h>
#include <stdlib.h>
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

/*CADDLL void salvarAluno(cad aluno)
{
   conn = connection();
   PQexec(conn, "INSERT into cad_aluno(nome, matricula, curso) values (aluno.nome, aluno.matricula, aluno.curso"); //cria insert no banco

	// Verifica se a consulta foi valida
	if (PQresultStatus(res) != PGRES_TUPLES_OK)
	{
		printf(PQerrorMessage(conn));
		PQclear(res);
		PQfinish(conn);
		return 1;
	}
	printf("\n\n\nValores salvos com sucesso.\n");
}

CADDLL cad recuperarAluno(char *nome)
{
	conn = connection();
    cad aluno = null;
    PGresult *res = PQexec(conn, "Select * from cad_aluno"); //consulta aluno banco
    if (PQresultStatus(res) != PGRES_TUPLES_OK)
	{
		printf(PQerrorMessage(conn));
		PQclear(res);
		PQfinish(conn);
		return 1;
	}

	aluno.nome = PQgetvalue (res, 1,1);
    aluno.matricula =PQgetvalue (res, 1,2);
    aluno.curso = PQgetvalue (res, 1,3);
    return aluno;
}

CADDLL void apagaAluno (char *alunonome){
	conn = connection();
	PQexec(conn, "DELETE from cad_aluno where nome = alunonome");
	    if (PQresultStatus(res) != PGRES_TUPLES_OK)
	{
		printf(PQerrorMessage(conn));
		PQclear(res);
		PQfinish(conn);
		return 1;
	}
	printf("\n\n\nApagado com sucesso.\n");
}
*/



