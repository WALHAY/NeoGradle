local M = {}

local function open_task_window()
    local buf = vim.api.nvim_create_buf(true, true)
    local win = vim.api.nvim_open_win(buf, true, {
        vertical = true,
        style = "minimal",
        width = 30
    })

    vim.api.nvim_buf_set_keymap(buf, "n", "q", "<cmd>exit<cr>", {})
    vim.api.nvim_buf_set_keymap(buf, "i", "q", "<cmd>exit<cr>", {})

    vim.api.nvim_buf_set_lines(buf, 0, 10, false, {
        "Gradle Tasks"
    })
end

M.config = function()
    vim.api.nvim_create_user_command("NeoGradleTasks", function() open_task_window() end, {})
    vim.keymap.set("n", "<leader>G", open_task_window, {})
end

return M
