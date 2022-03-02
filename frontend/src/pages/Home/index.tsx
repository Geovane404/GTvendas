import Footer from "components/Footer";
import NavBar from "components/NavBar";
import { Link } from "react-router-dom";

function Home() {

    return (
        <>

            <NavBar />
            <div className="container">
                <div className="jumbotron">
                    <h1 className="display-4">GTvendas</h1>
                    <p className="lead">Analise e Desempenho de vendas</p>
                    <hr />
                    <p>Esta aplicação consiste em exibir um Dashboard a partir de dados fornecidos por um Backend construído com Spring Boot.</p>
                    
                    <Link className="btn btn-primary btn-lg" to="/dashboard">
                        Acessar Aplicação
                    </Link>
                </div>
            </div>

            <Footer />

        </>
    );

}

export default Home;