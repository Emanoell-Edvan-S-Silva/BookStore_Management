package br.com.base.shared.DTOs;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "ProblemObject")
public record ProblemObjectDTO(
        @Schema(example = "name")
        String name,
        @Schema(example = "Name is required")
        String userMessage
) {
}
