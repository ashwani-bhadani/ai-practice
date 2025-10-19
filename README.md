# ai-practice
practicing AI modules from spring again


### properties that are useful
Here are some of the **most useful configuration properties** for the prefix `spring.ai.ollama.*` (for integrating Ollama with SpringAI) — along with what they do and when you might want to set them.

---

### 🔑 Core connection & startup properties

These affect how Spring AI connects to the Ollama API, how models are pulled at startup, etc.

| Property                                                                                             | Description                                                                                                        |
|------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| `spring.ai.ollama.base-url`                                                                          | The base URL where the Ollama API server is running. Default is `http://localhost:11434`.                          |
| `spring.ai.ollama.init.pull-model-strategy`                                                          | Controls whether models are pulled automatically at startup and *how*: e.g., `never`, `when_missing`, `always`.    |
| `spring.ai.ollama.init.timeout`                                                                      | How long to wait for a model pull to complete before timing out.                                                   |
| `spring.ai.ollama.init.max-retries`                                                                  | Maximum number of retries for the model pull operation.                                                            |
| `spring.ai.ollama.init.chat.include` / `spring.ai.ollama.init.embedding.include`                     | Whether the “chat” models / “embedding” models should be included in the initialization/pulling task at startup.   |
| `spring.ai.ollama.init.chat.additional-models` / `spring.ai.ollama.init.embedding.additional-models` | Additional model names (besides default) to pull/initialize at startup. Useful if you plan to use multiple models. |

---

### 🧠 Chat-model specific properties

When you’re using Ollama for chat/completion tasks, these help control which model, how it responds, etc.

| Property                                   | Description                                                                                                                                                             |
|--------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `spring.ai.model.chat`                     | Top-level property to select which chat provider or model integration is active. E.g., set this to `ollama` to enable Ollama’s chat integration.                        |
| `spring.ai.ollama.chat.options.model`      | The name of the model to use (e.g., `mistral`, `llama3.1:8b`, etc.) when using chat capability with Ollama.                                                             |
| `spring.ai.ollama.chat.options.format`     | The format to return a response in. For example, JSON format.                                                                                                           |
| `spring.ai.ollama.chat.options.keep_alive` | Controls how long the model will stay loaded into memory following the request (so it can reuse state or be faster) when using Ollama.                                  |
| *Other “options” properties*               | Many advanced low-level model parameters (depending on the model) may also be configurable via the `options` namespace — e.g., temperature, top-k, stop sequences, etc. |

---

### 🧮 Embeddings & other model-types

If you’re using Ollama for embeddings (vector representations) and not just chat, there are properties for that too.

| Property                                                                                         | Description                                                                              |
|--------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------|
| `spring.ai.model.embedding`                                                                      | Top-level property to select which embedding provider is active (e.g., set to `ollama`). |
| `spring.ai.ollama.embedding.options.model`                                                       | The model name for embeddings via Ollama.                                                |
| `spring.ai.ollama.embedding.options.keep_alive`                                                  | How long to keep the embedding model loaded.                                             |
| `spring.ai.ollama.embedding.options.truncate`                                                    | Whether to truncate input text when it exceeds context length for embedding.             |
| **Advanced embedding options**: `num-batch`, `num-gpu`, `low-vram`, `temperature`, `top-k`, etc. | These let you tune performance and quality of embedding generation.                      |

---