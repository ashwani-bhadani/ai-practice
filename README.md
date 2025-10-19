# ai-practice
practicing AI modules from spring again


### properties that are useful
---

### 🔑 Core connection properties

These are essential to get things communicating with OpenAI.

| Property                           | Description                                                                                                                             |
|------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------|
| `spring.ai.openai.api-key`         | Your OpenAI API key. Without this the client won’t authenticate.                                                                        |
| `spring.ai.openai.base-url`        | The base URL for the OpenAI API. Default is typically `api.openai.com`. Use this if you need to point to a proxy or alternate endpoint. |
| `spring.ai.openai.organization-id` | If you belong to multiple OpenAI org., specify which to use for the request.                                                            |
| `spring.ai.openai.project-id`      | Similar to org-id, for project scoping in OpenAI.                                                                                       |

---

### 🧠 Chat-model specific properties

If you’re using the chat models (e.g., GPT style conversational models) via Spring AI.

| Property                                               | Description                                                                                                                                         |
|--------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| `spring.ai.model.chat`                                 | Specifies which chat model implementation to enable. Default is `openai`.                                                                           |
| `spring.ai.openai.chat.options.model`                  | The name of the chat model to use (for example: `gpt-4o`, `gpt-4o-mini`, `gpt-3.5-turbo`, etc.).                                                    |
| `spring.ai.openai.chat.options.response-format.type`   | If using structured output / JSON schema output, specify the type (e.g., `JSON_SCHEMA`).                                                            |
| `spring.ai.openai.chat.options.response-format.schema` | The actual JSON schema to enforce the output shape. Useful for making the responses strongly typed.                                                 |
| `spring.ai.openai.chat.completions-path`               | The path under the base URL for the chat completions endpoint (defaults to something like `/v1/chat/completions`). Handy if you use a custom route. |

---

### 🔁 Retry / resilience properties

Important for production readiness: handling transient errors, retries, back-off, etc.

| Property                                   | Description                                                                                             |
|--------------------------------------------|---------------------------------------------------------------------------------------------------------|
| `spring.ai.retry.max-attempts`             | Maximum number of retry attempts when calling the API.                                                  |
| `spring.ai.retry.backoff.initial-interval` | Initial wait time for exponential backoff before retrying.                                              |
| `spring.ai.retry.backoff.multiplier`       | Multiplier for increasing backoff interval.                                                             |
| `spring.ai.retry.on-client-errors`         | Whether to retry when client (4xx) errors are seen. By default likely false (i.e., don’t retry on 4xx). |

---