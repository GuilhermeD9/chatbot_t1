import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
    const [qaList, setQaList] = useState([]);
    const [question, setQuestion] = useState('');
    const [answer, setAnswer] = useState('');

    useEffect(() => {
        // Fetch questions and answers from API
        axios.get('http://localhost:8080/api/qa')
            .then(response => {
                setQaList(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }, []);

    const handleSubmit = (e) => {
        e.preventDefault();
        const newQa = { question, answer };
        
        // Post new question and answer to the API
        axios.post('http://localhost:8080/api/qa', newQa)
            .then(response => {
                setQaList([...qaList, response.data]);
                setQuestion('');
                setAnswer('');
            })
            .catch(error => {
                console.error('Error posting data:', error);
            });
    };

    return (
        <div>
            <h1>Chatbot Q&A</h1>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    placeholder="Pergunta"
                    value={question}
                    onChange={(e) => setQuestion(e.target.value)}
                    required
                />
                <input
                    type="text"
                    placeholder="Resposta"
                    value={answer}
                    onChange={(e) => setAnswer(e.target.value)}
                    required
                />
                <button type="submit">Adicionar</button>
            </form>
            <h2>Lista de Perguntas e Respostas</h2>
            <ul>
                {qaList.map((qa) => (
                    <li key={qa.id}>
                        <strong>Pergunta:</strong> {qa.question}<br />
                        <strong>Resposta:</strong> {qa.answer}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default App;
